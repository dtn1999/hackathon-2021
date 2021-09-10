db.createUser({
    user: "admin",
    pwd: "adminPassword",
    roles: [{
        role: "readWrite",
        db: "pipele",
    }, ],
});