import { createContext, useContext, useState } from "react";

const TaskContext = createContext();

export default function ContextProvider({ children }) {
  const [isFormOpen, setIsFormOpen] = useState(false);
  const [isModalOpen, setIsModalOpen] = useState(false);

  return (
    <TaskContext.Provider
      value={{ isFormOpen, setIsFormOpen, isModalOpen, setIsModalOpen }}
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
