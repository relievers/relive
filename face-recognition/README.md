# face-recognition
## Installation and Running
Installation:
```plaintext
pip -r requirements.txt
```

Development server:
```plaintext
flask run
```

## Usage
### Find user images in event images
`POST /find-user-imgs-in-event-imgs`
```plaintext
Request body:
{
    'event_paths': [event_path1, event_path2, ...],
    'user_paths': [user_path1, user_path2, ...]
}
```

Response body:
```plaintext
{
    'event_path1': [user_path, ...],
    'event_path2': [user_path, ...],
    ...
}
```
