const https = require('https');

function makePostRequest(NIN) {
    const url = `https://ors.brela.go.tz/um/load/load_nida/${NIN}`;
    
    const options = {
        method: 'POST',
        headers: {
            'Content-Length': '0',
            'Content-Type': 'application/json'
        }
    };
    
    const req = https.request(url, options, (res) => {
        let data = '';
        
        res.on('data', (chunk) => {
            data += chunk;
        });
        
        res.on('end', () => {
            if (res.statusCode === 200) {
                console.log('Request was successful');
                console.log('Response:', JSON.parse(data));
            } else {
                console.log(`Failed to make request. Status code: ${res.statusCode}`);
                console.log('Response:', data);
            }
        });
    });
    
    req.on('error', (error) => {
        console.error(error);
    });
    
    req.end();
}

// Replace with the actual NIN
const NIN = 'YOUR NIDA ID';
makePostRequest(NIN);
