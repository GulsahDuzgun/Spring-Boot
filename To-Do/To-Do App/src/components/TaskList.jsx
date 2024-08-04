import { useQuery } from "@tanstack/react-query";
import TaskItem from "./TaskItem";

import { getTasks } from "../utils/service";

export default function TaskList() {
  const { data } = useQuery({
    queryFn: getTasks,
    queryKey: ["tasks"],
  });

  if (!data?.length)
    return <p className="no__task">There is no task to be shown 😐</p>;

  return (
    <ul className="taskContainer">
      <TaskItem tasks={data} />
    </ul>
  );
}
