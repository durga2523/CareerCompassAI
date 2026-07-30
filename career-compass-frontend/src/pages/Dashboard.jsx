function Dashboard(){
    return (
        <div className="container mt-5">
            <h1>Welcome to Career Compass AI 🚀</h1>

            <hr />

            <h4>Dashboard</h4>

            <div className="list-group mt-4">
                <button className="list-group-item list-group-item-action">
                    📄 Upload Resume
                </button>

                <button className="list-group-item list-group-item-action">
                    📊 ATS Score
                </button>

                <button className="list-group-item list-group-item-action">
                    🤖 AI Resume Analysis
                </button>

                <button className="list-group-item list-group-item-action">
                    💼 Job Match
                </button>

                <button className="list-group-item list-group-item-action text-danger">
                    Logout
                </button>

            </div>

        </div>
    );
}

export default Dashboard;
