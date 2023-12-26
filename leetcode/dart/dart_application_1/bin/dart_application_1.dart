import 'package:dart_application_1/dart_application_1.dart';
import 'package:dart_application_1/study.dart';
import 'package:test/test.dart';
import 'dart:io';

void main(List<String> arguments) async {
  print(await sumStream(countStream(10)));
}

void testDelay() async {
  countFunc();
  Future.delayed(Duration(seconds: 6), () => print("hello"));
  print(await asyncFunc());
  Future.delayed(Duration(seconds: 2));
}

void countFunc() async {
  for (int i = 1; i < 6; i++) {
    Future.delayed(Duration(seconds: i), () => stdout.write('$i '));
  }
  Future.delayed(Duration(seconds: 5), () => stdout.write('\n'));
}

Future<int> sumStream(Stream<int> stream) async {
  var sum = 0;
  await for (final value in stream) {
    sum += value;
  }
  return sum;
}

Stream<int> countStream(int to) async* {
  for (int i = 0; i < to; i++) {
    yield i;
  }
}
