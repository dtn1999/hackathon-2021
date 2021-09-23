import React from "react";
import Aggreement from "../../components/Aggreement";
import Image from "next/image";

const RegisterPage = () => {
    return (
        <div className="bg-white flex flex-col items-center pt-2">
            <div className="flex flex-row justify-items-center">
                <Image
                    className="object-cover"
                    src="/Amazon logo.png"
                    alt="Amazone logo"
                    width={140}
                    height={40}
                />
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
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
                        </div>
                    </div>
                    <div>
                        <label htmlFor="email" className="font-medium text-sm">
                            {" "}
                            Mobile number or email{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="text"
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
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
                                type="text"
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
                        </div>
                    </div>
                    <div>
                        <label
                            htmlFor="passwordConfirm"
                            className="font-medium text-sm">
                            {" "}
                            Re-enter password{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="text"
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
                        </div>
                    </div>
                    <button className="bg-amazon w-full font-normal rounded-sm border py-1.5 text-sm">
                        {" "}
                        Continue{" "}
                    </button>

                    <Aggreement />
                    <div className="w-full border bg-amazon my-5"></div>
                    <p className="text-xs tracking-wider">
                        Already have an account?{" "}
                        <a
                            href="#"
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
