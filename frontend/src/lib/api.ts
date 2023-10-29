const DATABASE_URL = 'http://localhost:8080/';

function get(path: string) {
	return fetch(DATABASE_URL + path, { method: 'GET' }).then((res) => {
		if (!res.ok) {
			throw res;
		}
		return res;
	});
}

function post(path: string, body) {
	return fetch(DATABASE_URL + path, {
		method: 'POST',
		headers: { 'content-type': 'application/json' },
		credentials: "include",
		body: JSON.stringify(body)
	}).then((res) => {
		if (!res.ok) {
			throw res;
		}
		return res;
	});
}

export default { get, post };
