import requests

def make_post_request(NIN):
    url = f'https://ors.brela.go.tz/um/load/load_nida/{NIN}'
    headers = {
        'Content-Length': '0',
        'Content-type': 'application/json'
    }

    response = requests.post(url, headers=headers)

    if response.status_code == 200:
        print('Request was successful')
        print('Response:', response.json())
    else:
        print(f'Failed to make request. Status code: {response.status_code}')
        print('Response:', response.text)

# Replace with the actual NIN
NIN = '199971225235010000126'
make_post_request(NIN)
