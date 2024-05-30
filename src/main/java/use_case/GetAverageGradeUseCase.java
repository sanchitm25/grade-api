package use_case;
import api.GradeDB;
import api.MongoGradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myTeam = gradeDB.getMyTeam();
        String[] members = myTeam.getMembers();
        float total = 0;
        for (String member : members) {
            Grade grade = gradeDB.getGrade(member, course);
            total += grade.getGrade();
        }
        return total / members.length;
    }
}
