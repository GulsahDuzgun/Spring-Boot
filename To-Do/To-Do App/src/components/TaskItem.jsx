import { HiMiniTrash, HiMiniPencilSquare } from "react-icons/hi2";
import { useTasks } from "../utils/ContextApi";
import { useQuery, useQueryClient } from "@tanstack/react-query";

const statusColors = {
  not_started: "#ff8787",
  in_progress: "#ffd43b",
  done: "#69db7c",
};

export default function TaskItem({ tasks }) {
  const { setDeleteModalOpen, setCurrentTask } = useTasks();

  function handleDeleteModal(task) {
    setDeleteModalOpen((s) => !s);
    setCurrentTask(task);
  }

  return tasks?.map((task, indx) => (
    <li className="task" key={indx}>
      <div className="task__detail">
        <span
          className="task__status"
          style={{
            backgroundColor:
              statusColors[
                `${task?.statusName?.replace(" ", "_").toLowerCase()}`
              ],
          }}
        >
          {task.statusName}
        </span>
        <p className="task__title">{task.taskName}</p>
        <p className="task__text">{task.task}</p>
      </div>
      <div className="task__btn">
        <button onClick={() => handleDeleteModal(task)}>
          <HiMiniPencilSquare />
        </button>
        <button onClick={() => handleDeleteModal(task)}>
          <HiMiniTrash />
        </button>
      </div>
    </li>
  ));
}
