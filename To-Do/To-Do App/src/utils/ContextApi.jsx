import { createContext, useContext, useState } from "react";

const TaskContext = createContext();

export default function ContextProvider({ children }) {
  const [isFormOpen, setIsFormOpen] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [modalWord, setModalWord] = useState("");
  const [currentTask, setCurrentTask] = useState({});

  return (
    <TaskContext.Provider
      value={{
        isFormOpen,
        setIsFormOpen,
        isModalOpen,
        setIsModalOpen,
        modalWord,
        setModalWord,
        currentTask,
        setCurrentTask,
      }}
    >
      {children}
    </TaskContext.Provider>
  );
}

export function useTasks() {
  const context = useContext(TaskContext);
  if (!context) throw new Error("Undefined Boundries");
  return context;
}
