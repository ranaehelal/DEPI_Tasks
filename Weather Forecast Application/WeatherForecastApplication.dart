import 'dart:async';
import 'dart:convert';//to convert the JSON to Map object

Future<String> fetchWeatherData() async {
  return Future.delayed(Duration(seconds: 2), () {
    return '{"location": "Maadi", "temperature": 35, "condition": "Hot"}'; //JSON text
  });

}
Future<Map<String, dynamic>?> parseWeatherData(String rawData) async {
    //  parsing the JSON
  try{
    final parsedData = jsonDecode(rawData); //jsonDecode frm json package dart :convert to map object
    return parsedData;
  }
  on FormatException catch (e) {
    print('A FormatException occurred: $e');
    return null;
  }
  catch (e) {
    print('Unexpected error: $e');
    return null;
  }
}
Future<void> displayWeatherInfo(Map<String, dynamic> weatherInfo) async {
  print("Weather Info: ");
  print('Location: ${weatherInfo['location']}');
  print('Temperature: ${weatherInfo['temperature']}C');
  print('Condition: ${weatherInfo['condition']}');
}
Future<void> mainApp() async {
  print("start");

  try {
    final rawData = await fetchWeatherData();
    final weatherInfo = await parseWeatherData(rawData);
    if (weatherInfo != null) {
      await displayWeatherInfo(weatherInfo);
    }
    else {
      print('No weather information available due to parsing error.');
    }
  }
  catch (e) {
    print('Error in mainApp: $e');
  }

  print("end");

}


void main() {
  mainApp();
  //runZonedGuarded(() async {await mainApp();}, (error, stackTrace) {print('Uncaught error: $error');});
}

