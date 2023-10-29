from flask import Flask, request, jsonify
from deepface import DeepFace

app = Flask(__name__)

"""
Rudimentary endpoint for retrieving lists in which users are recognized in 
event images using their profile picutre. Each recognized user profile 
picture also contains the x and y coordinates of the face in the event 
picture.

Request body:
{
    'event_paths': ['event_path1', 'event_path2', ...],
    'user_paths': ['user_path1', 'user_path2', ...]
}

Response body:
{
    'event_path1': [
        'user_path': {
            'x': x_coord,
            'y': y_coord
        }, ...
    ],
    'event_path2': [
        'user_path': {
            'x': x_coord,
            'y': y_coord
        }, ...
    ], ...
}
"""
@app.route('/find-user-imgs-in-event-imgs', methods=['POST'])
def find_user_imgs_in_event_imgs():
    try:
        req = request.get_json()

        event_imgs = req['event_paths']
        user_imgs = req['user_paths']

        res_map = {}

        for event in event_imgs:
            for user in user_imgs:
                result = DeepFace.verify(event, user, enforce_detection=False)
                print(result)
                if result['verified']:
                    if not event in res_map:
                        res_map[event] = list()
                    x = result['facial_areas']['img1']['x']
                    y = result['facial_areas']['img1']['y']

                    ret_user = {
                        user: {
                            'x': x,
                            'y': y
                        }
                    }

                    res_map[event].append(ret_user)

        return jsonify(res_map), 200
    
    except ValueError as err:
        return 'Error: ' + err, 422

@app.route('/test', methods=['GET'])
def test():
    return 'OK', 200
