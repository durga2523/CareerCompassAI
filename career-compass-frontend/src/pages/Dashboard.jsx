import { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import axios from "axios";

import dashboardContent from "../data/dashboardContent";

import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import UploadSection from "../components/UploadSection";
import AnalysisReport from "../components/AnalysisReport";
import Loading from "../components/Loading";
import PreviousAnalyses from "../components/PreviousAnalyses";

import { getUserResumes } from "../services/resumeService";

import "../styles/dashboard.css";

function Dashboard() {

    const navigate = useNavigate();
    const location = useLocation();

    const [showSidebar, setShowSidebar] = useState(false);
    const [selectedFile, setSelectedFile] = useState(null);
    const [analysis, setAnalysis] = useState(null);
    const [resumeHistory, setResumeHistory] = useState([]);
    const [loading, setLoading] = useState(false);

    const [currentPage, setCurrentPage] = useState(
        location.state?.page || "dashboard"
    );

    useEffect(() => {

        if (location.state?.page === "history") {

            setCurrentPage("history");
            loadHistory();

        }

    }, [location]);

    const handleLogout = () => {

        localStorage.removeItem("token");
        localStorage.removeItem("userId");

        navigate("/");

    };

    const loadHistory = async () => {

        try {

            const userId = localStorage.getItem("userId");

            if (!userId) return;

            const data = await getUserResumes(userId);

            setResumeHistory(data);

        } catch (error) {

            console.error(error);

        }

    };

    const handleAnalysis = async () => {

        if (!selectedFile) {

            alert("Please choose your resume first.");
            return;

        }

        const userId = localStorage.getItem("userId");

        if (!userId) {

            alert("Please login again.");
            navigate("/");
            return;

        }

        const token = localStorage.getItem("token");

        const formData = new FormData();

        formData.append("file", selectedFile);
        formData.append("userId", userId);

        try {

            setLoading(true);

            const uploadResponse = await axios.post(
                "http://localhost:8080/api/resumes/upload",
                formData,
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                        "Content-Type": "multipart/form-data"
                    }
                }
            );

            const resumeId = uploadResponse.data.id;

            const aiResponse = await axios.post(
                `http://localhost:8080/api/resumes/${resumeId}/ai-analysis`,
                {},
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            setAnalysis(aiResponse.data);

            await loadHistory();

        } catch (error) {

            console.error(error);

        } finally {

            setLoading(false);

        }

    };

    const handleHistoryClick = (resumeId) => {

        navigate(`/analysis/${resumeId}`);

    };

    return (

        <div className="d-flex dashboard-container">

            <Sidebar
                showSidebar={showSidebar}
                currentPage={currentPage}
                setCurrentPage={(page) => {

                    setCurrentPage(page);

                    if (page === "history") {
                        loadHistory();
                    }

                }}
            />

            <div
                className="container-fluid main-content"
                style={{
                    marginLeft: showSidebar ? "240px" : "0",
                    transition: ".3s"
                }}
            >

                <Navbar
                    showSidebar={showSidebar}
                    setShowSidebar={setShowSidebar}
                    onLogout={handleLogout}
                    appName={dashboardContent.appName}
                    logout={dashboardContent.logout}
                />

                <div className="text-center mt-5">

                    <h3 className="fw-semibold">
                        {dashboardContent.heading}
                    </h3>

                </div>

                {currentPage === "dashboard" && (

                    <>

                        <UploadSection
                            selectedFile={selectedFile}
                            setSelectedFile={setSelectedFile}
                            handleAnalysis={handleAnalysis}
                        />

                        <AnalysisReport analysis={analysis} />

                        {loading && <Loading />}

                    </>

                )}

                {currentPage === "history" && (

                    <PreviousAnalyses
                        resumes={resumeHistory}
                        onSelectResume={handleHistoryClick}
                    />

                )}

            </div>

        </div>

    );

}

export default Dashboard;