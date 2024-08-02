import "./App.css";
import Header from "./components/Header";
import Form from "./components/Form";
import StatusButtonsRow from "./components/StatusButtonsRow";
import TaskList from "./components/TaskList";

function App() {
  return (
    <>
      <div className='container'>
        <Header />
        <main className='main'>
          <StatusButtonsRow />
          <Form />
          <TaskList />
        </main>
      </div>
    </>
  );
}

export default App;
