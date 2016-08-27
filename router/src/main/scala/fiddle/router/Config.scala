package fiddle.router

import java.util.Properties

import com.typesafe.config.ConfigFactory

import scala.collection.JavaConverters._

object Config {
  protected val config = ConfigFactory.load().getConfig("fiddle")

  // read the generated version data
  protected val versionProps = new Properties()
  versionProps.load(getClass.getResourceAsStream("/version.properties"))

  val interface = config.getString("interface")
  val port = config.getInt("port")
  val analyticsID = config.getString("analyticsID")
  val scalaFiddleSourceUrl = config.getString("scalaFiddleSourceUrl")
  val scalaFiddleEditUrl = config.getString("scalaFiddleEditUrl")

  val corsOrigins = config.getStringList("corsOrigins").asScala

  object compiler {
    val c = config.getConfig("compiler")
    val host = c.getString("host")
    val port = c.getInt("port")
  }

  val version = versionProps.getProperty("version")
  val scalaVersion = versionProps.getProperty("scalaVersion")
  val scalaMainVersion = scalaVersion.split('.').take(2).mkString(".")
  val scalaJSVersion = versionProps.getProperty("scalaJSVersion")
  val scalaJSMainVersion = scalaJSVersion.split('.').take(2).mkString(".")
  val aceVersion = versionProps.getProperty("aceVersion")

  val logoLight = config.getString("logoLight")
  val logoDark = config.getString("logoDark")

  val extJS = config.getStringList("extJS").asScala
  val extCSS = config.getStringList("extCSS").asScala
  val baseEnv = config.getString("baseEnv")
  val clientFiles = config.getStringList("clientFiles").asScala

  val cacheDir = config.getString("cacheDir")
}
