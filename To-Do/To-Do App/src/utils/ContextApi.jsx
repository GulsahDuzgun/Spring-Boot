import { createContext, useContext, useState } from "react";

const TaskContext = createContext();

export default function ContextProvider({ children }) {
  const [isFormOpen, setIsFormOpen] = useState(false);
  const [isUpdateModalOpen, setUpdateModalOpen] = useState(false);
  const [isDeleteModalOpen, setDeleteModalOpen] = useState(false);
  const [currentTask, setCurrentTask] = useState({});

  return (
    <TaskContext.Provider
      value={{
        isFormOpen,
        setIsFormOpen,
        isUpdateModalOpen,
        setUpdateModalOpen,
        currentTask,
        setCurrentTask,
        isDeleteModalOpen,
        setDeleteModalOpen,
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
