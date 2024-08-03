import { createContext, useContext, useState } from "react";

const TaskContext = createContext();

export default function ContextProvider({ children }) {
  const [isFormOpen, setIsFormOpen] = useState(true);

  return (
    <TaskContext.Provider value={{ isFormOpen, setIsFormOpen }}>
      {children}
    </TaskContext.Provider>
  );
}

export function useTasks() {
  const context = useContext(TaskContext);
  if (!context) throw new Error("Undefined Boundries");
  console.log(context);
  return context;
}
