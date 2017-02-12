Aircraft
--------------------------------
--------------------------------

This simplified aircraft has three modes of operations, which correspond to the phases of flight: Take Off, Cruising, and Landing. Each of these has mode-specific behaviours that are only pertinent during that phase of flight. The aircraft also has persistent behaviours that are pertinent during all modes. The program is controlled by the `ACSafelet`, which starts the `MainMissionSequencer`. The `MainMission` controls the persistent schedulables, including the mission sequencer that is used to change between modes. The missions representing the modes (`TakeOffMission`, `CruiseMission`, `LandMission`) are controlled by the `ACModeChanger`, which is a mission sequencer. (The `ACModeChanger2` class is refactored for [TightRope](https://github.com/scjl2/circusTranslation.git).) Each of these missions controls its mode-specific schedulables. 

