import React from "react";
import Aggreement from "../../components/Aggreement";
import Image from "next/image";
import Link from "next/link";
import { useRouter } from "next/router";
import { useFormik } from "formik";
import RestClient from "../../services/RestClient";
import { registrationFormValidation, registrationIntialValues } from "./forms";

const RegisterPage = () => {
    const router = useRouter();
    const goToSignIn = React.useCallback(() => {
        router.push("/auth/login");
    }, []);
    const formik = useFormik({
        initialValues: {
            ...registrationIntialValues,
        },
        onSubmit: async (values, { resetForm, setErrors }) => {
            if (values.confirmPassword !== values.password) {
                setErrors({
                    confirmPassword:
                        "password confirmation doesn't match the password",
                });
                return;
            }
            const { confirmPassword, ...requestPayload } = values;
            const response = await RestClient.registerUser(requestPayload);
            console.log(response);
            if (response.success) {
                router.push("/");
                return;
            }

            alert(response.error);
            //  resetForm();
        },
        validationSchema: registrationFormValidation,
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
                        {" "}
                        Create account{" "}
                    </h1>
                    <div className="mt-1">
                        <label htmlFor="name" className="font-medium text-sm">
                            {" "}
                            Your name{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="text"
                                id="name"
                                value={formik.values.name}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                className={`px-2 w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none ${
                                    formik.errors.name
                                        ? "border-red-400 ring-2 ring-red-400"
                                        : ""
                                }`}
                            />
                            {formik.errors.name ? (
                                <span className="text-sm font-normal mt-4 text-red-500">
                                    {" "}
                                    {formik.errors.name}{" "}
                                </span>
                            ) : (
                                <></>
                            )}
                        </div>
                    </div>
                    <div>
                        <label htmlFor="email" className="font-medium text-sm">
                            {" "}
                            Mobile number or email{" "}
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
                        <label
                            htmlFor="password"
                            className="font-medium text-sm">
                            {" "}
                            Password{" "}
                        </label>
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
                    <div>
                        <label
                            htmlFor="confirmPassword"
                            className="font-medium text-sm">
                            {" "}
                            Re-enter password{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="password"
                                id="confirmPassword"
                                value={formik.values.confirmPassword}
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                className={`px-2 w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none ${
                                    formik.errors.confirmPassword
                                        ? "border-red-400 ring-2 ring-red-400"
                                        : ""
                                }`}
                            />
                            {formik.errors.confirmPassword ? (
                                <span className="text-sm font-normal mt-4 text-red-500">
                                    {" "}
                                    {formik.errors.confirmPassword}{" "}
                                </span>
                            ) : (
                                <></>
                            )}
                        </div>
                    </div>
                    <button
                        type="submit"
                        onClick={formik.handleSubmit}
                        className="bg-amazon w-full font-normal rounded-sm border py-1.5 text-sm">
                        {" "}
                        Continue{" "}
                    </button>

                    <Aggreement />
                    <div className="w-full border bg-amazon my-5"></div>
                    <p className="text-xs tracking-wider">
                        Already have an account?{" "}
                        <a
                            href="#"
                            onClick={goToSignIn}
                            className="text-link hover:text-amazon hover:underline">
                            Sign In
                        </a>
                    </p>
                    <p className="text-xs tracking-wider">
                        Buying for work?{" "}
                        <a
                            href="#"
                            className="text-link hover:text-amazon hover:underline">
                            Create a free buisiness account
                        </a>
                    </p>
                </form>
            </div>
        </div>
    );
};

export default RegisterPage;
