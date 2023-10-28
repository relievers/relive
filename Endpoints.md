# Endpoints for ReLive API

## Users

### Create new User

```
POST /users/
```

### Update User

```
PUT /users/<id>
```

## Events

### Retreive list of upcoming and past Events
```
GET /events/
```

### Create new Event
```
POST /events/
```

### Update Event
```
PUT /events/<id>
```

### Join existing Event
```
POST /events/<id>/participations
```

### Retreive all Members for specific Event
```
GET /events/<id>/participations
```

### Retreive MediaItems for Event
```
GET /events/<id>/medias
```

### Upload MediaItem
```
POST /events/<id>/medias
```

### Create new Comment
```
POST /events/<id>/medias/<id>/comments
```

### Retreive all Comments for one Media
```
GET /events/<id>/medias/<id>/comments
```