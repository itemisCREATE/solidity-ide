package com.yakindu.solidity.ide;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.yakindu.solidity.SolidityRuntimeModule;
import com.yakindu.solidity.solc.preferences.ICompilerPreferences;

/**
 * @author Jonathan Thoene - Initial contribution and API
 */
public class LanguageServerLauncher {

	public static final String COMPILER = "-compiler";
	
	public static void main(String[] args) throws InterruptedException, IOException {
		try {
			Options o = new Options();
			o.addOption(ServerLauncher.LOG.substring(1), false, "Log");
			o.addOption(ServerLauncher.TRACE.substring(1), false, "Trace");
			o.addOption(ServerLauncher.NO_VALIDATE.substring(1), false, "No Validate");
			o.addOption(COMPILER.substring(1), true, "Path to Solc Compiler (relative to working dir)");
			CommandLineParser p = new BasicParser();
			CommandLine cmd = p.parse(o, args);
			if (cmd.hasOption(COMPILER.substring(1))) {
				String compilerPath = cmd.getOptionValue(COMPILER.substring(1));
				ICompilerPreferences prefs = Guice.createInjector(Modules2.mixin(new SolidityRuntimeModule(), new SolidityIdeModule())).getInstance(ICompilerPreferences.class);
				String appDir = new File( "." ).getCanonicalPath();
				String theiaDir = appDir.substring(0, appDir.indexOf("app"));
				String absoluteCompilerPath = theiaDir + compilerPath;
				prefs.getPreferences().put(ICompilerPreferences.COMPILER_PATH, absoluteCompilerPath);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ServerLauncher.launch(LanguageServerLauncher.class.getName(), args, new ServerModule());
		/*
		 * Injector injector = Guice.createInjector(new ServerModule());
		 * LanguageServerImpl languageServer =
		 * injector.getInstance(LanguageServerImpl.class); Function<MessageConsumer,
		 * MessageConsumer> wrapper = consumer -> { return message -> {
		 * System.out.println(message); consumer.consume(message); }; };
		 * Launcher<LanguageClient> launcher = createSocketLauncher(languageServer,
		 * LanguageClient.class, new InetSocketAddress("localhost", 5007),
		 * Executors.newCachedThreadPool(), wrapper);
		 * languageServer.connect(launcher.getRemoteProxy()); Future<?> future =
		 * launcher.startListening(); while (!future.isDone()) { Thread.sleep(10_000l);
		 * }
		 */
	}

	/*
	 * static <T> Launcher<T> createSocketLauncher(Object localService, Class<T>
	 * remoteInterface, SocketAddress socketAddress, ExecutorService
	 * executorService, Function<MessageConsumer, MessageConsumer> wrapper) throws
	 * IOException { AsynchronousServerSocketChannel serverSocket =
	 * AsynchronousServerSocketChannel.open().bind(socketAddress);
	 * AsynchronousSocketChannel socketChannel; try { socketChannel =
	 * serverSocket.accept().get(); return Launcher.createIoLauncher(localService,
	 * remoteInterface, Channels.newInputStream(socketChannel),
	 * Channels.newOutputStream(socketChannel), executorService, wrapper); } catch
	 * (InterruptedException | ExecutionException e) { e.printStackTrace(); } return
	 * null; }
	 */

}
