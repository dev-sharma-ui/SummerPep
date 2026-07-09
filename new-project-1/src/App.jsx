import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import SubmitForm from "./components/SubmitForm";
import FeedbackForm from "./components/FeedbackForm";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SubmitForm />} />
        <Route path="/feedback" element={<FeedbackForm />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;