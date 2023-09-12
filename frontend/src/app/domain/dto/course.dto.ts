import {LessonDTO} from "./lesson.dto";
import {OutlineDTO} from "./outline.dto";

export interface CourseDTO {
  name: string
  description: string
  header: string
  lessons: Array<LessonDTO>
  outlines: Array<OutlineDTO>
}
