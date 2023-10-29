const DATABASE_URL = 'http://localhost:8080/';

function getToken() {
	return 'Bearer ' + localStorage.getItem('token') ?? '';
}

function get(path: string) {
	return fetch(DATABASE_URL + path, { method: 'GET', headers: { Atuhorization: getToken() } }).then(
		(res) => {
			if (!res.ok) {
				throw res;
			}
			return res;
		}
	);
}

function post(path: string, body) {
	return fetch(DATABASE_URL + path, {
		method: 'POST',
		headers: { 'content-type': 'application/json', Authorization: getToken() },
		body: JSON.stringify(body)
	}).then((res) => {
		if (!res.ok) {
			throw res;
		}
		return res;
	});
}

export default { get, post };
