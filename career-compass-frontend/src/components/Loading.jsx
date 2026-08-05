import "../styles/loading.css";

function Loading() {

    return (

        <div className="loading-overlay">

            <div className="loading-spinner"></div>

            <h3>Analyzing Resume...</h3>

            <p>AI is evaluating your resume.</p>

        </div>

    );

}

export default Loading;