const DATABASE_URL = 'http://localhost:8080/';

function get(path: string) {
	return fetch(DATABASE_URL + path, { method: 'GET' });
}

function post(path: string, body) {
	return fetch(DATABASE_URL + path, { method: 'GET', body: body });
}

export default { get, post };
