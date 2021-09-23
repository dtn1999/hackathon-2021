import React from "react";
import { Provider } from "react-redux";
import { store } from "../app/store";

import "react-toastify/dist/ReactToastify.css";
import "../styles/globals.css";
import "../styles/custom.css";

import StorageService from "../services/StorageService";
import { Provider as AuthProvider } from "next-auth/client";
import { ToastContainer, Zoom } from "react-toastify";
import { hydrate } from "../slices/basketSlice";
import AuthContext from "../context/AuthContext";

store.subscribe(() => {
    StorageService.set("basket", JSON.stringify(store.getState().basket));
});

let basket = StorageService.get("basket");
basket = basket ? JSON.parse(basket) : { items: [] };
store.dispatch(hydrate(basket));

const MyApp = ({ Component, pageProps }) => {
    const [user, setUser] = React.useState({});

    return (
        <AuthProvider session={pageProps.session}>
            <AuthContext.Provider
                value={{
                    setUser,
                    user,
                }}>
                {/* Gives the session's info to the components via a Provider */}
                <Provider store={store}>
                    <Component {...pageProps} />
                    <ToastContainer transition={Zoom} />
                </Provider>
            </AuthContext.Provider>
        </AuthProvider>
    );
};

export default MyApp;
