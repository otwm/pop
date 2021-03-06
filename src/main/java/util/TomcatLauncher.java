package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * heroku build용 톰캣 런처
 * 
 * @author kdo
 *
 */
public class TomcatLauncher {
	/**
	 * heroku path
	 */
	private static String webAppDir = "/app/src/main/webapp";

	// private static String webAppDir = "C:/Users/kdo/git/pop/src/main/webapp";

	/**
	 * tomcat start
	 * 
	 * @param args 
	 * @throws IOException
	 * @throws LifecycleException
	 * @throws ServletException
	 */
	public static void main(final String[] args) throws IOException,
			LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(getPort(args));

		tomcat.addWebapp("/", new File(webAppDir).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();
	}

	/**
	 * port 설정
	 * @param args
	 * @return
	 */
	private static int getPort(String[] args) {
		if (args.length > 0) {
			for (String arg : args) {
				if (arg.indexOf("port") > 0) {
					return Integer.parseInt(arg.split("=")[1]);
				}
			}
		}
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 80;
	}
}
