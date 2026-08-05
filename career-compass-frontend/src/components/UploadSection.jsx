import "../styles/upload.css";
import dashboardContent from "../data/dashboardContent";

function UploadSection({
                           selectedFile,
                           setSelectedFile,
                           handleAnalysis
                       }) {

    return (

        <section className="upload-section">

            <h2 className="upload-heading">
                {dashboardContent.heading}
            </h2>

            <p className="upload-subtitle">
                Upload your resume in PDF format to receive an AI-powered analysis.
            </p>

            <div className="upload-area">

                <input
                    type="file"
                    id="resume"
                    accept=".pdf"
                    hidden
                    onChange={(e) => setSelectedFile(e.target.files[0])}
                />

                <label
                    htmlFor="resume"
                    className="choose-file-btn"
                >
                    Choose Resume
                </label>

                <p className="selected-file">

                    {selectedFile
                        ? selectedFile.name
                        : "No file selected"}

                </p>

            </div>

            <button
                className="analyze-button"
                disabled={!selectedFile}
                onClick={handleAnalysis}
            >
                Analyze Resume
            </button>

        </section>

    );

}

export default UploadSection;