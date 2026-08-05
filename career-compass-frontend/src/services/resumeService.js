import axios from "axios";

const BASE_URL = "http://localhost:8080/api/resumes";

const getAuthHeader = () => ({
    headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`
    }
});

export const getUserResumes = async (userId) => {

    const response = await axios.get(
        `${BASE_URL}/user/${userId}`,
        getAuthHeader()
    );

    return response.data;
};

export const getSavedAnalysis = async (resumeId) => {

    const response = await axios.get(
        `${BASE_URL}/${resumeId}/analysis`,
        getAuthHeader()
    );

    return response.data;
};