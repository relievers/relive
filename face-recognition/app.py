from flask import Flask, request, jsonify#, BadRequest
from deepface import DeepFace

app = Flask(__name__)

"""
Rudimentary endpoint for retrieving lists in which users are recognized in 
event images using their profile picutre.

Request body:
{
    'events': [event_path1, event_path2, ...],
    'users': [user_path1, user_path2, ...]
}

Response body:
{
    'event_path1': [user_path, ...],
    'event_path2': [user_path, ...],
    ...
}

TODO: Configure deployment
"""
@app.route('/find-user-imgs-in-events', methods=['POST'])
def find_user_imgs_in_events():
    try:
        req = request.get_json()
        print(req)

        event_imgs = req['events']
        user_imgs = req['users']

        res_map = {}

        for event in event_imgs:
            for user in user_imgs:
                result = DeepFace.verify(event, user, enforce_detection=False)
                if result['verified']:
                    if not event in res_map:
                        res_map[event] = list()
                    res_map[event].append(user)

        return jsonify(res_map), 200
    
    except ValueError as err:
        return 'Error: ' + err, 422

@app.route('/test', methods=['GET'])
def test():
    return 'OK', 200