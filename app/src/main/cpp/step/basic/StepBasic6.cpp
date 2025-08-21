#include <jni.h>
#include <memory>
#include <array>

namespace StepBasic6 {
    struct Skill {
        std::unique_ptr<int> skill1;
        std::unique_ptr<int> skill2;
        std::unique_ptr<int> skill3;
        std::unique_ptr<int> skill4;
    } skill;

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic6_dataLoad(
            JNIEnv *env, jobject thiz, jboolean is_created
    ) {
        if (is_created) {
            skill.skill1 = std::make_unique<int>(1);
            skill.skill2 = std::make_unique<int>(1);
            skill.skill3 = std::make_unique<int>(1);
            skill.skill4 = std::make_unique<int>(1);
        } else {
            skill.skill1.reset();
            skill.skill2.reset();
            skill.skill3.reset();
            skill.skill4.reset();
        }
    }

    extern "C"
    JNIEXPORT jintArray JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic6_skillArray(
            JNIEnv *env, jobject thiz
    ) {
        std::array<jint, 4> stdArray = {*skill.skill1, *skill.skill2, *skill.skill3, *skill.skill4};
        jintArray intArray = env->NewIntArray(stdArray.size());
        env->SetIntArrayRegion(intArray, 0, stdArray.size(), stdArray.data());
        return intArray;
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic6_upgrade(
            JNIEnv *env, jobject thiz
    ) {
        *skill.skill1 += 1;
        *skill.skill2 += 1;
        *skill.skill3 += 1;
        *skill.skill4 += 1;
    }

    extern "C"
    JNIEXPORT jboolean JNICALL
    Java_me_hd_ggtutorial_ui_fragment_step_basic_StepBasic6_success(
            JNIEnv *env, jobject thiz
    ) {
        return *skill.skill4 > 666
               && *skill.skill1 < 100
               && *skill.skill2 < 100
               && *skill.skill3 < 100;
    }
}