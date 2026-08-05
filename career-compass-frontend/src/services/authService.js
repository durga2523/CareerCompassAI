import axios from "axios";

const BASE_URL = "https://career-compass-backend-fxzr.onrender.com";

export const loginUser = async (loginData) => {

    const response = await axios.post(
        `${BASE_URL}/api/users/login`,
        loginData
    );

    return response.data;
};

export const registerUser = async (registerData) => {

    const response = await axios.post(
        `${BASE_URL}/api/users/register`,
        registerData
    );

    return response.data;
};