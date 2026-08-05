import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getSavedAnalysis } from "../services/resumeService";
import AnalysisReport from "../components/AnalysisReport";
import Loading from "../components/Loading";
import "../styles/dashboard.css";
import "../styles/analysis.css";

function AnalysisDetails() {

    const { resumeId } = useParams();

    const navigate = useNavigate();

    const [analysis, setAnalysis] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        const loadAnalysis = async () => {

            try {

                const data = await getSavedAnalysis(resumeId);
                setAnalysis(data);

            } catch (error) {

                console.error(error);

            } finally {

                setLoading(false);

            }
        };

        loadAnalysis();

    }, [resumeId]);

    if (loading) {
        return <Loading />;
    }

    return (

        <div className="dashboard-container">
            <div className="container-fluid main-content">

            <button
                className="btn btn-outline-light mb-4"
                onClick={() => navigate("/dashboard", {
                    state: {
                        page: "history"
                    }
                })} >
                ← Back
            </button>

            <AnalysisReport analysis={analysis} />

        </div>
        </div>

    );
}

export default AnalysisDetails;