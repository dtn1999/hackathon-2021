import React from "react";
import Image from "next/image";
import { useRouter } from "next/router";
import Link from "next/link";
import Aggreement from "../../components/Aggreement";
import { useFormik } from "formik";
import { loginFormValidation, loginIntialValues } from "./forms";
import AuthContext from "../../context/AuthContext";
import RestClient from "../../services/RestClient";

const loginPage = () => {
    const router = useRouter();
    const navigateToRegistration = React.useCallback(() => {
        router.push("/auth/register");
    }, []);

    const { setUser } = React.useContext(AuthContext);

    const formik = useFormik({
        initialValues: {
            ...loginIntialValues,
        },
        onSubmit: async (values, {}) => {
            console.log("heool");
            const response = await RestClient.logUserIn(values);
            console.log(response);
            if (response.success) {
                const { username, userEmail } = response;
                setUser({
                    username,
                    userEmail,
                });
                router.push("/");
                return;
            }

            alert(response.error);
            //  resetForm();
        },
        validationSchema: loginFormValidation,
    });

    return (
        <div className="bg-white flex flex-col items-center pt-16">
            <div className="flex flex-row justify-items-center">
                <Link href="/">
                    <a>
                        <Image
                            className="object-cover"
                            src="/Amazon logo.png"
                            alt="Amazone logo"
                            width={140}
                            height={40}
                        />
                    </a>
                </Link>
            </div>
            <div className="min-w-max mt-3">
                <form
                    className="w-max border rounded-sm px-4 py-5 space-y-4"
                    style={{ width: 360 }}>
                    <h1 className="mb-4 font-medium text-2xl tracking-wide text-gray-700">
                        Sign-In
                    </h1>

                    <div>
                        <label htmlFor="email" className="font-medium text-sm">
                            {" "}
                            Email or mobile phone number{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="email"
                                id="email"
                                value={formik.values.email}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                className={`px-2 w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none ${
                                    formik.errors.email
                                        ? "border-red-400 ring-2 ring-red-400"
                                        : ""
                                }`}
                            />
                            {formik.errors.email ? (
                                <span className="text-sm font-normal mt-4 text-red-500">
                                    {" "}
                                    {formik.errors.email}{" "}
                                </span>
                            ) : (
                                <></>
                            )}
                        </div>
                    </div>
                    <div>
                        <div className="flex flex-row justify-between">
                            <label
                                htmlFor="password"
                                className="font-medium text-sm">
                                {" "}
                                Password{" "}
                            </label>
                            <a
                                href="#"
                                className="text-link text-sm hover:text-amazon hover:underline">
                                Forgot password
                            </a>
                        </div>
                        <div className="mt-1">
                            <input
                                type="password"
                                id="password"
                                value={formik.values.password}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                className={`px-2 w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none ${
                                    formik.errors.password
                                        ? "border-red-400 ring-2 ring-red-400"
                                        : ""
                                }`}
                            />
                            {formik.errors.password ? (
                                <span className="text-sm font-normal mt-4 text-red-500">
                                    {" "}
                                    {formik.errors.password}{" "}
                                </span>
                            ) : (
                                <></>
                            )}
                        </div>
                    </div>

                    <button
                        type="button"
                        disabled={!formik.isValid}
                        onClick={() => {
                            formik.handleSubmit();
                            console.log("after ");
                        }}
                        className="bg-amazon w-full font-normal rounded-sm border py-1.5 text-sm">
                        Sign-In
                    </button>

                    <Aggreement />
                </form>
                <div className="flex flex-row items-center">
                    <div className="flex-1 border bg-amazon my-5"></div>
                    <p className="text-xs font-medium text-gray-500 mx-1">
                        {" "}
                        New to Amazone clone?
                    </p>
                    <div className="flex-1 border bg-amazon my-5"></div>
                </div>

                <button
                    type="button"
                    className="bg-gray-200 w-full font-normal rounded-sm border py-1.5 text-sm"
                    onClick={navigateToRegistration}>
                    Create Your Amazone clone account
                </button>
            </div>
        </div>
    );
};

export default loginPage;
