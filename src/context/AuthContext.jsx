import React from "react";

const AuthContext = React.createContext({
    user: undefined,
    setUser: (user) => {},
});

export default AuthContext;
