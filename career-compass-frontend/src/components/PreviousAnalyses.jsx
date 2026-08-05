import "../styles/history.css";

function PreviousAnalyses({ resumes, onSelectResume }) {

    return (

        <section className="history-section">

            <h2 className="history-title">
                Previous Analysis
            </h2>

            {resumes.length === 0 ? (

                <p>No previous analyses found.</p>

            ) : (

                resumes.map((resume) => (

                    <div
                        key={resume.id}
                        className="history-item"
                        onClick={() => onSelectResume(resume.id)}
                    >

                        <h5>{resume.fileName}</h5>

                        <p>
                            {new Date(resume.uploadedAt).toLocaleString()}
                        </p>

                    </div>

                ))

            )}

        </section>

    );

}

export default PreviousAnalyses;