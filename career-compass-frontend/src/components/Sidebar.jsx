import "../styles/sidebar.css";

function Sidebar({
                     showSidebar,
                     currentPage,
                     setCurrentPage
                 }) {

    return (
        <div className={`sidebar ${showSidebar ? "show" : ""}`}>

            <button
                className={`sidebar-item ${currentPage === "dashboard" ? "active" : ""}`}
                onClick={() => setCurrentPage("dashboard")}
            >
                Dashboard
            </button>

            <button
                className={`sidebar-item ${currentPage === "history" ? "active" : ""}`}
                onClick={() => setCurrentPage("history")}
            >
                Previous Analysis
            </button>

        </div>
    );
}

export default Sidebar;