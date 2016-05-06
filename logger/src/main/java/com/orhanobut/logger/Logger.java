package com.orhanobut.logger;

/**
 * Logger is a wrapper of {@link android.util.Log}
 * But more pretty, simple and powerful
 */
public final class Logger {
  private static final String DEFAULT_TAG = "PRETTYLOGGER";

  private static Printer printer;

  //no instance
  private Logger() {
  }

  /**
   * It is used to get the settings object in order to change settings
   *
   * @return the settings object
   */
  public static Settings init() {
    return init(DEFAULT_TAG);
  }

  /**
   * It is used to change the tag
   *
   * @param tag is the given string which will be used in Logger as TAG
   */
  public static Settings init(String tag) {
    printer = new LoggerPrinter();
    return printer.init(tag);
  }
  public static void check() {
    if (printer == null) {
      Logger.init();
    }
  }
  public static void clear() {
    printer.clear();
    printer = null;
  }

  public static Printer t(String tag) {
    check();
    return printer.t(tag, printer.getSettings().getMethodCount());
  }

  public static Printer t(int methodCount) {
    check();
    return printer.t(null, methodCount);
  }

  public static Printer t(String tag, int methodCount) {
    check();
    return printer.t(tag, methodCount);
  }

  public static void d(String message, Object... args) {
    check();
    printer.d(message, args);
  }

  public static void e(String message, Object... args) {
    check();
    printer.e(null, message, args);
  }

  public static void e(Throwable throwable, String message, Object... args) {
    check();
    printer.e(throwable, message, args);
  }

  public static void i(String message, Object... args) {
    check();
    printer.i(message, args);
  }

  public static void v(String message, Object... args) {
    check();
    printer.v(message, args);
  }

  public static void w(String message, Object... args) {
    check();
    printer.w(message, args);
  }

  public static void wtf(String message, Object... args) {
    check();
    printer.wtf(message, args);
  }

  /**
   * Formats the json content and print it
   *
   * @param json the json content
   */
  public static void json(String json) {
    check();
    printer.json(json);
  }

  /**
   * Formats the json content and print it
   *
   * @param xml the xml content
   */
  public static void xml(String xml) {
    check();
    printer.xml(xml);
  }

}
