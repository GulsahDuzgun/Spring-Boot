import "./App.css";
import Header from "./components/Header";
import Form from "./components/Form";
import StatusButtonsRow from "./components/StatusButtonsRow";
import TaskList from "./components/TaskList";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";
import ContextProvider from "./utils/ContextApi";

function App() {
  const queryClient = new QueryClient({
    defaultOptions: {
      queries: {
        staleTime: 5 * 60 * 1000,
      },
    },
  });

  return (
    <QueryClientProvider client={queryClient}>
      <ContextProvider>
        <ReactQueryDevtools initialIsOpen={false} />
        <div className="container">
          <Header />
          <main className="main">
            <StatusButtonsRow />
            <Form />
            <TaskList />
          </main>
        </div>
      </ContextProvider>
    </QueryClientProvider>
  );
}

export default App;
