import 'package:http/http.dart' as http;
import 'dart:convert';

Future<void> makePostRequest(String NIN) async {
  final url = 'https://ors.brela.go.tz/um/load/load_nida/$NIN';
  
  final headers = {
    'Content-Length': '0',
    'Content-Type': 'application/json',
  };
  
  final response = await http.post(Uri.parse(url), headers: headers);
  
  if (response.statusCode == 200) {
    print('Request was successful');
    print('Response: ${jsonDecode(response.body)}');
  } else {
    print('Failed to make request. Status code: ${response.statusCode}');
    print('Response: ${response.body}');
  }
}

void main() {
  // Replace with the actual NIN
  const NIN = 'YOUR NIDA ID';
  makePostRequest(NIN);
}
