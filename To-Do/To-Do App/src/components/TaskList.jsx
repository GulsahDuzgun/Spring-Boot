import { useQuery } from "@tanstack/react-query";
import TaskItem from "./TaskItem";

import { getTasks } from "../utils/service";

export default function TaskList() {
  const { data } = useQuery({
    queryFn: getTasks,
    queryKey: ["tasks"],
  });

  return (
    <ul className="taskContainer">
      <TaskItem tasks={data} />
    </ul>
  );
}
