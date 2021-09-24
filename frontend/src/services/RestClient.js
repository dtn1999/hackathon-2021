import * as axios from "axios";

export default {
    registerUser: async(resgistrationRequest) => {
        if (resgistrationRequest) {
            const response = await fetch(
                "http://localhost:8080/api/auth/register", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(resgistrationRequest),
                }
            ).then((res) => res.json());

            if (response.success) {
                localStorage.setItem(
                    "amazone-clone-auth",
                    JSON.stringify(response.data)
                );
            }
            const { username, userEmail } = response.data;

            return {
                username,
                userEmail,
                success: true,
            };
        }
        return { success: false };
    },
    logUserIn: async(loginRequest) => {
        if (loginRequest) {
            const response = await fetch(
                "http://localhost:8080/api/auth/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(loginRequest),
                }
            ).then((res) => res.json());

            if (response.success) {
                localStorage.setItem(
                    "amazone-clone-auth",
                    JSON.stringify(response.data)
                );
            }
            const { username, userEmail } = response.data;

            return {
                username,
                userEmail,
                success: true,
            };
        }
        return { success: false };
    },

    logUserOut: async() => {
        const response = await fetch("http://localhost:8080/api/auth/logout", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
        }).then((res) => res.json());

        if (response.success) {
            localStorage.setItem("amazone-clone-auth", ``);
        }
        return response;
    },
};