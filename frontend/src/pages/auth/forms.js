import * as Yup from "yup";

export const registrationIntialValues = {
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
};

export const loginIntialValues = {
    email: "",
    password: "",
};

export const registrationFormValidation = Yup.object({
    name: Yup.string().min(3).max(50).required(),
    email: Yup.string().email().required(),
    password: Yup.string().min(6).required(),
    confirmPassword: Yup.string().min(6).required(),
});

export const loginFormValidation = Yup.object({
    email: Yup.string().email().required(),
    password: Yup.string().min(6).required(),
});