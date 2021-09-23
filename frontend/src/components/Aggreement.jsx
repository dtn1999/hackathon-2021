import React from "react";

const Aggreement = () => {
    return (
        <p className="mt-7 text-xs tracking-wider">
            By creating an account you agree to Amazon's
            <a
                href="#"
                className="text-link  hover:text-amazon hover:underline">
                {"    "}Conditions of Use & Sale.
            </a>
            {"    "}Please see our
            <a href="#" className="text-link hover:text-amazon hover:underline">
            {"    "}Privacy Notice
            </a>
            , our
            <a href="#" className="text-link hover:text-amazon hover:underline">
            {"    "} Cookies Notice
            </a>
            and our
            <a href="#" className="text-link hover:text-amazon hover:underline">
                Interest-Based Ads Notice
            </a>
            .
        </p>
    );
};

export default Aggreement;
