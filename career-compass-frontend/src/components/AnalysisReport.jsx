import dashboardContent from "../data/dashboardContent";
import "../styles/analysis.css";

function AnalysisReport({ analysis }) {

    if (!analysis) return null;

    return (

        <section className="analysis-section">

            <h2 className="analysis-title">
                {dashboardContent.reportTitle}
            </h2>

            {/* ATS Score */}

            <div className="ats-container">

                <div
                    className="progress-ring"
                    style={{
                        background: `conic-gradient(
            #22c55e ${analysis.atsScore * 3.6}deg,
            #2b2b2b 0deg
        )`
                    }}
                >
                    <div className="progress-inner">
            <span className="ats-score">
                {analysis.atsScore}%
            </span>
                    </div>
                </div>

                <p className="ats-title">
                    {dashboardContent.atsTitle}
                </p>

            </div>


            <hr className="analysis-divider" />

            {/* Professional Summary */}

            <h3 className="section-title">
                {dashboardContent.summaryTitle}
            </h3>

            <p className="summary">
                {analysis.resumeSummary}
            </p>

            <hr className="analysis-divider" />

            {/* Detected Skills */}

            <h3 className="section-title">
                {dashboardContent.detectedSkillsTitle}
            </h3>

            <div className="mb-5">

                {analysis.detectedSkills?.map((skill, index) => (

                    <span
                        key={index}
                        className="skill-chip"
                    >
                        {skill}
                    </span>

                ))}

            </div>

            <hr className="analysis-divider" />

            {/* Missing Skills */}

            <h3 className="section-title">
                {dashboardContent.missingSkillsTitle}
            </h3>

            <div className="mb-5">

                {analysis.missingSkills?.map((skill, index) => (

                    <span
                        key={index}
                        className="skill-chip"
                    >
                        {skill}
                    </span>

                ))}

            </div>

            <hr className="analysis-divider" />

            {/* Recommendations */}

            <h3 className="section-title">
                {dashboardContent.recommendationTitle}
            </h3>

            <ol className="recommendation-list">

                {analysis.recommendations?.map((item, index) => (

                    <li key={index}>
                        {item}
                    </li>

                ))}

            </ol>

        </section>

    );
}

export default AnalysisReport;