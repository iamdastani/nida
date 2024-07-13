<?php

function makePostRequest($NIN) {
    $url = 'https://ors.brela.go.tz/um/load/load_nida/' . $NIN;

    $headers = [
        'Content-Length: 0',
        'Content-type: application/json'
    ];

    $options = [
        'http' => [
            'header' => implode("\r\n", $headers),
            'method' => 'POST'
        ]
    ];

    $context = stream_context_create($options);
    $response = file_get_contents($url, false, $context);

    if ($response !== FALSE) {
        $statusCode = intval(explode(' ', $http_response_header[0])[1]);
        if ($statusCode == 200) {
            echo "Request was successful\n";
            echo "Response: " . $response . "\n";
        } else {
            echo "Failed to make request. Status code: " . $statusCode . "\n";
            echo "Response: " . $response . "\n";
        }
    } else {
        echo "Failed to make request.\n";
    }
}

// Replace with the actual NIN
$NIN = 'YOUR NIDA ID';
makePostRequest($NIN);

?>
