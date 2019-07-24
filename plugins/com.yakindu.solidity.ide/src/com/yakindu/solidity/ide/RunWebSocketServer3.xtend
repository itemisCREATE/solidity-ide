package com.yakindu.solidity.ide

import com.google.inject.Guice
import com.google.inject.Injector
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.function.Function
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.jsonrpc.MessageConsumer
import org.eclipse.lsp4j.launch.LSPLauncher.Builder
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer

class RunWebSocketServer3 {

	def static void main(String[] args) {

		var String host = "localhost";
		var int port = 5007;
		var Injector injector = Guice.createInjector(new ServerModule())
		var MyDslWebSocketServer server = new MyDslWebSocketServer(new InetSocketAddress(host, port)) {

			override void run() {
				super.run()
			}

		};

		var LanguageServerImpl languageServer = injector.getInstance(LanguageServerImpl)
		var Function<MessageConsumer, MessageConsumer> wrapper = [ consumer |
			{
				var MessageConsumer result = consumer

				return result
			}
		]
		var Launcher<LanguageClient> launcher = new Builder<LanguageClient>().setLocalService(languageServer).
			setRemoteInterface(LanguageClient).setInput(server.in).setOutput(server.out).setExecutorService(
				Executors.newCachedThreadPool()).wrapMessages(wrapper).create();
		languageServer.connect(launcher.getRemoteProxy())
		var Future<?> future = launcher.startListening()

		server.run();
		while (!future.isDone()) {
			if (future.isDone()) {
				languageServer.shutdown()
			}
		}
	}

}

class MyDslWebSocketServer extends WebSocketServer {

	public var out = new ByteArrayOutputStream() {

		override flush() throws IOException {
			super.flush()
			var s = new String(toByteArray, StandardCharsets.UTF_8)
			var i = s.indexOf("\r\n\r\n")
			if (i > 0) {
				s = s.substring(i + 4)
			}
			println(s)
			conn.send(s)
			reset
		}

	}

	var PipedOutputStream pipe = new PipedOutputStream
	public var PipedInputStream in = new PipedInputStream(pipe)

	var WebSocket conn;

	new(InetSocketAddress a) {
		super(a)
	}

	override onClose(WebSocket conn, int code, String reason, boolean remote) {
	}

	override onError(WebSocket conn, Exception ex) {
		ex.printStackTrace
	}

	override onMessage(WebSocket conn, String message) {
		System.err.println("message: " + message)
		pipe.write(("Content-Length: " + message.length + "\r\n\r\n").getBytes(StandardCharsets.US_ASCII))
		pipe.write(message.getBytes(StandardCharsets.UTF_8))
		pipe.flush
	}

	override onOpen(WebSocket conn, ClientHandshake handshake) {
		System.err.println("open")
		this.conn = conn;
	}

	override onStart() {
		System.err.println("start")
	}

}
