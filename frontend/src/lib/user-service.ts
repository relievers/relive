export function getUser() {
    return JSON.parse(localStorage.getItem("user"))
}

export function setUser(user) {
    localStorage.setItem("user", JSON.stringify(user));
}