import React from "react";
import Image from "next/image";
import Aggreement from "../../components/Aggreement";

const loginPage = () => {
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
                        Sign-In
                    </h1>

                    <div>
                        <label htmlFor="email" className="font-medium text-sm">
                            {" "}
                            Email or mobile phone number{" "}
                        </label>
                        <div className="mt-1">
                            <input
                                type="text"
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
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
                                type="text"
                                className="w-full rounded-sm border py-0.5 focus:ring-1 focus:ring-amazon focus:border-amazon focus:outline-none"
                            />
                        </div>
                    </div>

                    <button className="bg-amazon w-full font-normal rounded-sm border py-1.5 text-sm">
                        {" "}
                        Sign-In{" "}
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

                <button className="bg-gray-200 w-full font-normal rounded-sm border py-1.5 text-sm">
                    Create Your Amazone clone account
                </button>
            </div>
        </div>
    );
};

export default loginPage;
