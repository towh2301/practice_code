Future<String> asyncFunc() {
  return Future.delayed(Duration(seconds: 5), () => "Hello");
}
