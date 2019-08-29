package com.yakindu.solidity.ide;

import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.xtend.lib.macro.file.Path;
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
		
		// Define program options
		Options o = new Options();		
		o.addOption(ServerLauncher.LOG.substring(1), false, "Log");
		o.addOption(ServerLauncher.TRACE.substring(1), false, "Trace");
		o.addOption(ServerLauncher.NO_VALIDATE.substring(1), false, "No Validate");
		o.addOption(COMPILER.substring(1), true, "Path to Solc Compiler (relative to working dir)");
		
		try {
			// jvm options
			String baseDir = System.getProperty("basedir");
			
			CommandLineParser p = new BasicParser();
			CommandLine cmd = p.parse(o, args);
			if (cmd.hasOption(COMPILER.substring(1))) {
				String compilerPath = cmd.getOptionValue(COMPILER.substring(1)).replace("${os}", getOS());
				String absoluteCompilerPath = baseDir + Path.SEGMENT_SEPARATOR + compilerPath;
				ICompilerPreferences prefs = Guice
						.createInjector(Modules2.mixin(new SolidityRuntimeModule(), new SolidityIdeModule()))
						.getInstance(ICompilerPreferences.class);
				prefs.getPreferences().put(ICompilerPreferences.COMPILER_PATH, absoluteCompilerPath);
			}
			ServerLauncher.launch(LanguageServerLauncher.class.getName(), args, new ServerModule());
		} 
		catch( ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("YAKINDU solidity language server", o, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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

	private static CharSequence getOS() {
		if (SystemUtils.IS_OS_LINUX) {
			return "linux";
		} else if (SystemUtils.IS_OS_WINDOWS) {
			return "win32";
		} else if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
			return "macosx";
		} else {
			throw new IllegalArgumentException("Unsupported OS");
		}
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
